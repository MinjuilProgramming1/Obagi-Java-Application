import java.util.Random;

public class TortoiseAndHareRace {
    static final int FINISH_LINE = 70;

    public static void main(String[] args) {
        Random random = new Random();
        int tortoise = 1, hare = 1, tick = 0;

        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!");

        while (tortoise < FINISH_LINE && hare < FINISH_LINE) {
            tick++;
            // Move tortoise
            int tortoiseMove = random.nextInt(10) + 1;
            if (tortoiseMove <= 5) tortoise += 3; // Fast plod
            else if (tortoiseMove <= 7) tortoise -= 6; // Slip
            else tortoise += 1; // Slow plod

            // Move hare
            int hareMove = random.nextInt(10) + 1;
            if (hareMove <= 2) hare += 0; // Sleep (no move)
            else if (hareMove <= 4) hare += 9; // Big hop
            else if (hareMove == 5) hare -= 12; // Big slip
            else if (hareMove <= 8) hare += 1; // Small hop
            else hare -= 2; // Small slip

            // Ensure positions don't go below 1
            tortoise = Math.max(1, tortoise);
            hare = Math.max(1, hare);

            // Display race track
            printRaceTrack(tortoise, hare);

            // Check for winners
            if (tortoise >= FINISH_LINE && hare >= FINISH_LINE) {
                System.out.println("It's a tie!");
                break;
            } else if (tortoise >= FINISH_LINE) {
                System.out.println("TORTOISE WINS!!! YAY!!!");
                break;
            } else if (hare >= FINISH_LINE) {
                System.out.println("Hare wins. Yuch.");
                break;
            }

            // Wait for next tick (simulating real-time)
            try {
                Thread.sleep(500); // 0.5s delay per tick (adjust for longer races)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void printRaceTrack(int tortoise, int hare) {
        StringBuilder track = new StringBuilder(" ".repeat(FINISH_LINE));

        if (tortoise == hare) {
            track.setCharAt(tortoise - 1, 'O'); // OUCH!!!
        } else {
            track.setCharAt(tortoise - 1, 'T');
            track.setCharAt(hare - 1, 'H');
        }

        System.out.println(track);
    }
}
