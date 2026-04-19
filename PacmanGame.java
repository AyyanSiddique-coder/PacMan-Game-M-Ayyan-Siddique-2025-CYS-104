package CEP_1;
    import java.util.Scanner;

    public class PacmanGame {

        static char[][] map = {
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','#','#','.','#','#','.','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','#','.','#','#','#','.','#','.','#'},
                {'#','.','.','.','.','.','.','#','.','#'},
                {'#','.','#','#','.','#','.','.','.','#'},
                {'#','.','.','.','.','.','.','#','.','#'},
                {'#','.','.','#','#','.','.','.','.','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };

        static int pacX = 1, pacY = 1;
        static int score = 0;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while (true) {
                printMap();

                System.out.println("Score: " + score);
                System.out.print("Move (W/A/S/D): ");
                char move = sc.next().toUpperCase().charAt(0);

                int newX = pacX;
                int newY = pacY;

                if (move == 'W') newX--;
                else if (move == 'S') newX++;
                else if (move == 'A') newY--;
                else if (move == 'D') newY++;
                else {
                    System.out.println("Invalid move!");
                    continue;
                }

                // Check wall
                if (map[newX][newY] != '#') {

                    // Eat food
                    if (map[newX][newY] == '.') {
                        score += 10;
                    }

                    map[pacX][pacY] = ' ';
                    pacX = newX;
                    pacY = newY;
                    map[pacX][pacY] = 'P';
                }

                // Win condition
                if (checkWin()) {
                    printMap();
                    System.out.println("🎉 YOU WIN! Final Score: " + score);
                    break;
                }
            }

            sc.close();
        }

        static void printMap() {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (i == pacX && j == pacY)
                        System.out.print('P');
                    else
                        System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

        static boolean checkWin() {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == '.') return false;
                }
            }
            return true;
        }
    }

