import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
public class HomeWork3_1 {
        public static void main(String... args) {

            try {
                enterData();
                System.out.println("success");
            } catch (FileSystemException fse) {
                System.out.println(fse.getMessage());
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }

        }

        private static void enterData() throws Exception {
            System.out.println("Enter surname, name, patroname, date of birth (dd.mm.yyyy), " +
                    "phone number и sex(f or m) by space");

            String text;
            try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
                text = bfr.readLine();
            } catch (IOException ioe) {
                throw new RuntimeException("something wrong");
            }

            String[] array = text.split(" ");
            if (array.length != 6) {
                throw new RuntimeException("wrong parameters");
            }

            String surname = array[0];
            String name = array[1];
            String patroname = array[2];

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
            Date birthdate;
            try {
                birthdate = simpleDateFormat.parse(array[3]);
            } catch (ParseException paE) {
                throw new ParseException("wrong date of birth", paE.getErrorOffset());
            }

            int phone;
            try {
                phone = Integer.parseInt(array[4]);
            } catch (NumberFormatException nufe) {
                throw new NumberFormatException("wrong phone number");
            }

            String sex = array[5];
            if (!sex.equalsIgnoreCase("m") && !sex.equalsIgnoreCase("f")) {
                throw new RuntimeException("wrong sex");
            }

            String fileName = surname.toLowerCase() + ".txt";
            File file = new File(fileName);
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                if (file.length() > 0) {
                    fileWriter.write("\n");
                }
                fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patroname, simpleDateFormat.format(birthdate), phone, sex));
            } catch (IOException ioe) {
                throw new FileSystemException("error save in file");
            }
        }
    }
