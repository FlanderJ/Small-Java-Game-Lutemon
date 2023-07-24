# Small-Java-Game-Lutemon
A small turn-based game, somehow similar to old Pokemon games.

There are 5 main functions in this game, which can be seen from the main view as the game is started:
1. "Add new Lutemon"
   - The player can select from 5 different Lutemons and give a name for a Lutemon.
   - After a Lutemon is created, it is added to the "Home" location.
2. "List all Lutemons"
   - All created Lutemons are listed here in a recycler view and their attribute information is shown here.
4. "Transfer Lutemons"
   - Players can transfer the Lutemons into different locations; Home, Training or Combat.
   - As Lutemon visits "Home" Locations its health is set to full.
   - As Lutemon visits the "Training" location its experience increases and therefore also stats of that Lutemon increase.
   - As Lutemon is moved to the "Combat" location, it appears in the "Combat arena".
6. "Combat arena"
   - Players can select which two Lutemons will fight each other.
   - As the fight begins, the fight will be visualised.
   - The winner increases their stats, and the loser won't get anything.
   - The fight count, lose count and win count will be increased accordingly and shown in the "Statistics" view.
8. "Statistics"
   - The fight counts, win counts, and lose counts are represented in a bar diagram, each count on its fragment page.
  
All Lutemons will be saved into memory and loaded there when the game is restarted.

NOTE! The game is not optimized in any way, its main purpose is to show understanding of Java programming and use of Android Studio.
