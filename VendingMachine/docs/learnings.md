# Learnings

- The app should call `VendingMachine`, not state classes directly.
- State is internal to the machine.
- `VendingMachine` should route events to the current state.
- State classes should call internal helper methods on `VendingMachine` for actual work.
