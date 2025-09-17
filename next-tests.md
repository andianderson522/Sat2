# Next Tests List

## Format
- Priority: 0 (Highest) to 4 (Lowest)
- Status: 🔴 Not Started | 🟡 In Progress | 🟢 Completed

## Dice System
- 🔴 P0 - DiceRollerTest
  - Should roll N number of N-sided dice (NdN)
  - Should calculate total for multiple dice
  - Should roll with advantage (take highest of 2d20)
  - Should roll with disadvantage (take lowest of 2d20)
  - Should support different die types (d4, d6, d8, d10, d12, d20, d100)
  - Should validate dice input format (e.g., "2d6+1", "1d20-2")
  - Should correctly apply positive modifiers to roll total
  - Should correctly apply negative modifiers to roll total
  - Should treat modifiers as optional parameters
  - Should treat advantage/disadvantage as optional parameters
  - Should handle rolls with no optional parameters (basic NdN)
  - Should allow combining optional parameters (e.g., advantage with modifier)

- 🔴 P1 - DiceResultTest
  - Should store individual die results
  - Should track if roll was advantage/disadvantage
  - Should provide roll metadata (timestamp, reason for roll)
  - Should support roll modifiers (+/-N to total)
  - Should handle missing optional parameters with default values

## Character Management
- 🔴 P0 - CharacterCreationTest
  - Should create character with valid attributes
  - Should reject invalid character names
  - Should set default values for new characters
  - Should generate unique character ID

- 🔴 P0 - CharacterRepositoryTest
  - Should save character to database
  - Should retrieve character by ID
  - Should update existing character
  - Should delete character

## Inventory System
- 🔴 P1 - InventoryManagementTest
  - Should add item to character inventory
  - Should remove item from inventory
  - Should calculate inventory weight
  - Should enforce inventory size limits

- 🔴 P1 - CharacterProgressionTest
  - Should level up character
  - Should calculate experience points
  - Should unlock abilities at appropriate levels
  - Should update character stats on level up

## Journal System
- 🔴 P1 - JournalEntryTest
  - Should create user journal entry with Markdown
  - Should validate Markdown formatting
  - Should store entry metadata (timestamp, author, tags)
  - Should link entry to game entities

- 🔴 P1 - SystemJournalGeneratorTest
  - Should generate entry from game event
  - Should use correct template for event type
  - Should include relevant game state
  - Should maintain chronological order

## Quest System
- 🔴 P2 - QuestSystemTest
  - Should create new quest
  - Should track quest objectives
  - Should complete quest
  - Should reward character appropriately

- 🔴 P2 - CombatSimulatorTest
  - Should calculate attack outcomes
  - Should apply damage to characters
  - Should track combat rounds
  - Should generate combat log

## Integration Features
- 🔴 P3 - GameStateManagementTest
  - Should save complete game state
  - Should load saved game state
  - Should handle corrupted save data
  - Should migrate old save formats

- 🔴 P3 - RESTAPITest
  - Should expose character endpoints
  - Should handle concurrent requests
  - Should validate input data
  - Should return appropriate error codes

## Journal Features
- 🔴 P3 - JournalFormattingTest
  - Should render Markdown correctly
  - Should sanitize user input
  - Should handle embedded images/links
  - Should support custom templates

- 🔴 P3 - JournalSearchTest
  - Should search by content
  - Should filter by metadata
  - Should support tag-based queries
  - Should return paginated results

## Notes
- Tests should be implemented in priority order (P0 → P4)
- Each test implementation should follow TDD principles
- Update status emoji as tests progress
- Add notes/dependencies as needed under each test