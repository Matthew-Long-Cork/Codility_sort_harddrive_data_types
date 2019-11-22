import java.util.Scanner;

public class Solution {

    public static String solution( String data) {

        // varibales
        String extractedSize ="";
        String extractedType = "";
        int fileSize = 0;
        int lastIndex;
        int whiteSpace;
        int indexOfDot;

        //DATA SIZE:
        int musicFileSize = 0;
        int imageFileSize = 0;
        int movieFileSize  = 0;
        int otherFileSize = 0;
        String dataString = "";

        Scanner scanner = new Scanner(data);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // process the line

            //==================================================================
            // get the size:
            //==================================================================
            // get the last index and the white space index
            lastIndex = line.lastIndexOf('b');
            whiteSpace = line.indexOf(' ');
            indexOfDot = line.lastIndexOf('.');
            // extract the substring and convert to int
            extractedSize = line.substring(whiteSpace, lastIndex);
            fileSize = Integer.parseInt(extractedSize.trim());

            //==================================================================
            // get the type:
            //==================================================================
            extractedType = line.substring(indexOfDot +1, whiteSpace);
            if(extractedType.equals("mp3") ||extractedType.equals("aac") || extractedType.equals("flac")){
                musicFileSize = musicFileSize + fileSize;
            }
            else if(extractedType.equals("jpg") ||extractedType.equals("bmp") || extractedType.equals("gif")){
                imageFileSize = imageFileSize + fileSize;
            }
            else if(extractedType.equals("mp4") ||extractedType.equals("avi") || extractedType.equals("mkv")){
                movieFileSize = movieFileSize + fileSize;
            }
            else{
                otherFileSize = otherFileSize + fileSize;
            }
        }
        scanner.close();

        dataString = "music " + musicFileSize + "b\n" + "images " + imageFileSize + "b\n"
                + "movies " + movieFileSize + "b\n" + "other " + otherFileSize + "b";

        return dataString;
    }

    //=========================================
    // the main below was just to run for testing purposes
    public static void main(String args[]) {

        // allocating the info to the string ------- for testing
        String data = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5lb\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";

        //pass in string to function
        String answer = solution(data);
        // print answer...
        System.out.println("The answer is:\n" + answer);
    } // end of main
} // end of class
