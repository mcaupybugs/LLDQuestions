# Snake and Ladder Learnings

## Design Learnings
- Keep `BoardEntity` as the common abstraction for both `Snake` and `Ladder`.
- Store snakes and ladders on the board as a fast lookup map from `start -> end`.
- Use a builder for `Game` creation when multiple collaborators are needed: `Board`, `Dice`, and players.
- Use a `Queue<Player>` to naturally model turn rotation.
- Keep movement rules inside `Board` so the game loop remains simple.
