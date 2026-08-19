# TicTacToe Learnings

## Encapsulation

- Keep fields `private` by default.
- Expose state only when needed through a getter or through behavior-oriented methods.
- Public mutable fields are risky because they can be changed without guardrails.
- Public fields are acceptable mainly for constants or very simple immutable data holders.

## Responsibility Separation

- `Game` should orchestrate the flow, not own every rule in the system.
- `Board` should manage board state and move placement.
- Winner calculation should not be hardcoded inside `Board` if extensibility is a goal.
- A `Player` should represent a participant, not directly mutate board cells.

## Design Patterns Used

- **Strategy Pattern**
	- `IWinningStrategy` defines the winner-checking contract.
	- `DefaultWinningStrategy` provides the current implementation.
	- Benefit: winner rules can be changed later without changing `Game` or `Board`.

- **State Modeling**
	- `GameStatus` is used to represent `IN_PROGRESS`, `DRAW`, and `WIN`.
	- Benefit: game lifecycle becomes explicit and easier to reason about.

- **Encapsulation / Information Hiding**
	- `Slot` and `Player` hide internal state and expose controlled access.
	- Benefit: protects invariants and reduces accidental misuse.

## Interview Takeaways

- Single responsibility matters even in small systems.
- Avoid weak abstractions that do not model real behavior.
- Prefer extensible designs only where variation is likely.
- Start simple, then extract patterns like Strategy when a rule is likely to change.
- A small system can still demonstrate clean OO design through separation of concerns and proper modeling.
