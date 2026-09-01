# Task Manager Learnings

- Whenever behavior changes based on the current state, use the State pattern.
- If an object moves through distinct stages and allowed actions depend on the current stage, model it as a machine with explicit states.
- State transitions should be handled inside the main machine/system object, while each state encapsulates valid behavior for that stage.
- For searching tasks by multiple optional filters, prefer a dedicated `TaskSearchCriteria` object instead of many overloaded methods.
- Keep basic search logic as in-memory filtering over all tasks first; add indexes later only if search becomes frequent or performance-critical.
- Observer pattern can be kept simple here: after important setter-based changes, send an update/notification to all registered observers.
