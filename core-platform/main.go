package main

import (
	"encoding/json"
	"fmt"
	"net/http"
)

// Requirement representa o contrato de dados que o Starter enviará
type Requirement struct {
	ID              string   `json:"id"`
	Title           string   `json:"title"`
	Description     string   `json:"description"`
	ContentMarkdown string   `json:"content_markdown"`
	Priority        string   `json:"priority"`
	Status          string   `json:"status"`
	Connections     []Connection `json:"connections"`
}

type Connection struct {
	TargetID string `json:"target_id"`
	Type     string `json:"type"`
}

// In-memory storage para o MVP
var requirements = make(map[string]Requirement)

func main() {
	http.HandleFunc("/docflow/requirements", func(w http.ResponseWriter, r *http.Request) {
		if r.Method != http.MethodPost {
			http.Error(w, "Method not allowed", http.StatusMethodNotAllowed)
			return
		}

		var req Requirement
		if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
			http.Error(w, err.Error(), http.StatusBadRequest)
			return
		}

		// Salva no mapa em memória
		requirements[req.ID] = req
		fmt.Printf("Received requirement: %s\n", req.ID)

		w.Header().Set("Content-Type", "application/json")
		w.WriteHeader(http.StatusCreated)
		json.NewEncoder(w).Encode(map[string]string{"status": "success", "message": "Requirement received"})
	})

	fmt.Println("DocFlow Core Platform running on :9090")
	http.ListenAndServe(":9090", nil)
}
