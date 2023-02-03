import java.io.*;


public class CopyFile {

    public static void main(String[] args) {

        // Check if the source and destination file names are provided as arguments
        if (args.length < 2) {
            System.out.println("Please provide the source and destination file names as arguments.");
            return;
        }

        // Get the source and destination file names from the command line arguments
        String sourceFileName = args[0];
        String destFileName = args[1];

        try {
            // Make the system call to open the source file
            FileInputStream sourceFileStream = new FileInputStream(sourceFileName);

            // Make the system call to create the destination file
            FileOutputStream destFileStream = new FileOutputStream(destFileName);

            // Copy the contents of the source file to the destination file
            int content;
            while ((content = sourceFileStream.read()) != -1) {
                destFileStream.write(content);
            }

            // Close the file streams
            sourceFileStream.close();
            destFileStream.close();

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while copying the file: " + e.getMessage());
        }
    }
}
