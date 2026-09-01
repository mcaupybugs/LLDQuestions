# Task Management System Question

## Problem Statement

Design a low level design for a task management system.

A task management system helps users create, assign, track, and complete tasks while organizing work across individuals or teams. The system should support task lifecycle management, searching, filtering, reminders, and task history.

## Requirements

### Functional Requirements

- Allow users to create, update, and delete tasks
- Each task should have:
  - title
  - description
  - due date
  - priority
  - status such as `pending`, `in progress`, and `completed`
- Allow users to assign tasks to other users
- Allow users to set reminders for tasks
- Support searching and filtering tasks based on criteria such as:
  - priority
  - due date
  - assigned user
  - status
- Allow users to mark tasks as completed
- Allow users to view task history

### Behavioral Constraints

- The system should handle concurrent access to tasks safely
- The design should ensure data consistency when multiple users access or update tasks
- Task state changes should be reflected consistently across the system
- Searching and filtering should work efficiently over the in-memory task collection

### Non-Functional Requirements

- Keep the design object-oriented, modular, and extensible
- The system should be easy to maintain and test
- The design should allow future enhancements and new features with minimal changes
- Focus on low level design and class responsibilities, not database or distributed system design

## Suggested Design Discussion

While solving, consider:

- Core entities such as `User`, `Task`, `Reminder`, and task history
- Appropriate enums for `TaskStatus` and `Priority`
- A central `TaskManager` or service layer to manage tasks
- Thread-safe data structures for concurrent access
- How to model assignment, reminders, and history tracking cleanly
- How to keep the design open for future filters, notifications, or analytics features
