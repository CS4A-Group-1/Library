import java.io.*;

public class LibraryFileIO {
    //=====================================
    //  Constructors
    private LibraryFileIO() {}

    //=====================================
    // LibraryStorage I/O Operations

    public static LibraryStorage loadLibraryData(String filename) {
        LibraryStorage savedStorage;
        try (
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        ) {
            LibraryStorage storage = (LibraryStorage)input.readObject();
            savedStorage = storage;
        }
        catch (IOException | ClassNotFoundException ex) {
            savedStorage = new LibraryStorage();
        }
        return savedStorage;
    }

    public boolean saveLibraryData(LibraryStorage storage, String filename) {
        try (
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename, false));
        ) {
            output.writeObject(storage);
            return true;
        }
        catch (IOException ex) {
            return false;
        }
    }
}
