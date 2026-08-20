# Snake and Ladder Architecture

## Overview
The system models a turn-based Snake and Ladder game using a small set of domain objects.

## Components
- `SnakeLadderApp`: entry point, prepares sample data and starts the game.
- `Game`: orchestrates the gameplay loop and player turns.
- `Game.Builder`: constructs a valid `Game` object.
- `Board`: owns board size and transition rules for snakes and ladders.
- `BoardEntity`: base abstraction for board transitions.
- `Snake` / `Ladder`: concrete board entities.
- `Player`: stores player identity and current position.
- `Dice`: encapsulates dice rolling behavior.

## Mermaid Diagram
```mermaid
classDiagram
    class SnakeLadderApp {
        +main(args: String[]): void
    }

    class Game {
        -board: Board
        -players: Queue~Player~
        -dice: Dice
        -gameStatus: GameStatus
        +startGame(): void
        +takeTurn(player: Player): void
    }

    class Builder {
        -board: Board
        -players: Queue~Player~
        -dice: Dice
        +setBoard(boardSize: int, entities: Map~Integer, BoardEntity~): Builder
        +setPlayers(playerNames: List~String~): Builder
        +setDice(dice: Dice): Builder
        +build(): Game
    }

    class Board {
        -snakeAndLadder: Map~Integer, Integer~
        -size: int
        +getFinalPosition(currentPosition: int, diceRoll: int): int
        +checkWinCondition(currentPosition: int): boolean
    }

    class BoardEntity {
        <<abstract>>
        -start: int
        -end: int
        +getStart(): int
        +getEnd(): int
    }

    class Snake
    class Ladder

    class Player {
        -name: String
        -position: int
        +move(finalPosition: int): void
        +getPosition(): int
        +getName(): String
    }

    class Dice {
        -minValue: int
        -maxValue: int
        +rollDice(): int
    }

    class GameStatus {
        <<enumeration>>
        IN_PROGRESS
        FINISHED
        NOT_STARTED
    }

    SnakeLadderApp --> Game
    Game --> Board
    Game --> Dice
    Game --> Player
    Game ..> Builder
    Builder --> Board
    Builder --> Dice
    Builder --> Player
    BoardEntity <|-- Snake
    BoardEntity <|-- Ladder
    Board --> BoardEntity
```

## Flow
1. `SnakeLadderApp` creates snakes, ladders, player names, and dice.
2. `Game.Builder` assembles the `Game`.
3. `Game.startGame()` runs a loop until a player reaches the final cell.
4. On each turn, `Dice` generates a roll.
5. `Board` resolves the next position and applies any snake or ladder jump.
6. `Player` state is updated.

## Current Strengths
- Simple and easy to understand.
- Good separation between orchestration, board rules, and player state.
- Easy to extend for different board sizes or dice behavior.
