---------------------------------
Phase 1 — Understand neural networks
-------------------------------
1.  Embeddings : 
2. Positional encoding 
3. Q, K, V
4. Self-attention
5. Multi-head attention
6. Feed-forward network
7. Layer normalization
8. Residual connections
9. Transformer block
10. Stack transformer blocks
11. Output layer
12. Softmax
13. Loss
14. Backpropagation
15. Gradient descent
16. Training loop
--------------------------------------

Then we'll build a tiny language model from scratch.

Not a useful LLM yet — something tiny where you can actually see the numbers changing.

Phase 2 — Build a miniature LLM

We'll make something like:

"what is my"
       ↓
predict next token
       ↓
"class"

Then:

"what is my class"
       ↓
"tomorrow"

You'll understand exactly what every component is doing.

Phase 3 — Make it actually useful

Then we move into:

University data
      ↓
Database
      ↓
LLM
      ↓
Tool/database queries
      ↓
Natural language response

Add:

student accounts
department
section
semester
teachers
courses
rooms
dates
schedules
authentication
conversation history
personalized defaults
Phase 4 — Make it feel like a real assistant

Eventually:

Student: What do I have tomorrow?

AI: You have three classes tomorrow. DBMS at 9:00 in Room 301, Computer Networks at 11:30 in Room 204, and AI at 2:00 in Room 402.

Student: Who teaches the second one?

AI: Computer Networks is taught by Dr. Rahman.

Student: What about Thursday?

AI: You have...

The model isn't memorizing all those facts. It's understanding the conversation and retrieving the correct structured information.