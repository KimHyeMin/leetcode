package problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2 {

  private static final Set<String> MUSIC_EXT = new HashSet<>(Arrays.asList("mp3", "aac", "flac"));
  private static final Set<String> IMAGE_EXT = new HashSet<>(Arrays.asList("jpg", "bmp", "gif"));
  private static final Set<String> MOVIE_EXT = new HashSet<>(Arrays.asList("mp4", "avi", "mkv"));

  public String solution(String S) {
    String[] lines = S.split("\n");

    long[] stored = new long[4];

    for (String line : lines) {
      String[] fileSplits = line.split(" ");

      String fileName = fileSplits[0];
      int index = fileName.lastIndexOf(".");
      String extension = fileName.substring(index+1);

      long fileSize = Long.parseLong(fileSplits[1].substring(0, fileSplits[1].length()-1));

      if (MUSIC_EXT.contains(extension)) {
        stored[0] = stored[0] + fileSize;
      } else if(IMAGE_EXT.contains(extension)) {
        stored[1] = stored[1] + fileSize;
      } else if (MOVIE_EXT.contains(extension)) {
        stored[2] = stored[2] + fileSize;
      } else {
        stored[3] = stored[3] + fileSize;
      }
    }

    return String.format("music %sb\n", stored[0])
         + String.format("images %sb\n", stored[1])
         + String.format("movies %sb\n", stored[2])
         + String.format("other %sb\n", stored[3]);
  }

  public static void main(String[] args) {
    Test2 dut = new Test2();
    String solution = dut.solution("my.song.mp3 11b\n"
        + "greatSong.flac 1000000b\n"
        + "not3.txt 1000000b\n"
        + "video.mp4 1000000b\n"
        + "game.exe 1000000b\n"
        + "game1.exe 1000000b\n"
        + "game.mp3 0b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "game.exe 1000000b\n"
        + "mov!e.mkv 1000000b");

    System.out.println(solution);

  }
}
