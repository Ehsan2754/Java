package Spring2020.DSA4;

import java.util.*;


public class DSA4Task3 {
    public static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int nCMD = user.nextInt();
        user.nextLine();
        for (int i = 0; i < nCMD; i++) {
            applyCMD(user.nextLine().split(","));
        }
    }

    public static void applyCMD(final String[] cmd) throws IllegalArgumentException {
        String[] aCMD = cmd[0].split(" ");

        switch (aCMD[0]) {
            case "ADD":
                phoneBook.putIfAbsent(getFullName(aCMD), new ArrayList<>());
                if (!phoneBook.get(getFullName(aCMD)).contains(getPhoneNumber(cmd)))
                    phoneBook.get(getFullName(aCMD)).add(getPhoneNumber(cmd));
                break;
            case "DELETE":
                if (cmd.length > 1) {

                    if (phoneBook.containsKey(getFullName(aCMD))) {
                        if (phoneBook.get(getFullName(aCMD)).contains(getPhoneNumber(cmd))) {
                            phoneBook.get(getFullName(aCMD)).remove(getPhoneNumber(cmd));
                            if (phoneBook.get(getFullName(aCMD)).size() == 0) {
                                phoneBook.remove(getFullName(aCMD));
                            }
                        }

                    }
                } else if (cmd.length == 1) {
                    if (phoneBook.containsKey(getFullName(aCMD))) phoneBook.remove(getFullName(aCMD));
                }
                break;
            case "FIND":
                if (!phoneBook.containsKey(getFullName(aCMD)))
                    System.out.println("No contact info found for " + getFullName(aCMD));
                else {
                    System.out.print(String.format("Found %d phone numbers for %s:",
                            phoneBook.get(getFullName(aCMD)).size(),
                            getFullName(aCMD)));
                    phoneBook.get(getFullName(aCMD)).forEach(e -> System.out.println(" " + e));

                }
                break;
        }

    }


    static String getFullName(final String[] aCMD) {
        String fullName = "";
        for (int i = 1; i < aCMD.length; i++) {
            if (i == 1) fullName = aCMD[1];
            else
                fullName += " " + aCMD[i];
        }
        return fullName;
    }

    static String getPhoneNumber(final String[] cmd) {

        return cmd[1];

    }
}
