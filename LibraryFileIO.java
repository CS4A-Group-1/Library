import java.io.*;

public class LibraryFileIO {
    
    //=====================================
    //  Data

    private String filename;

    //=====================================
    //  Constructors

    // TODO
    public LibraryFileIO(String filename) {
        this.filename = filename;
    }

    //=====================================
    // Read Operations

    // TODO
    public LibraryStorage loadLibraryData() {
        LibraryStorage savedStorage;
        try (
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(this.filename));
        ) {
            LibraryStorage storage = (LibraryStorage)input.readObject();
            savedStorage = storage;
        }
        catch (IOException | ClassNotFoundException ex) {
            savedStorage = new LibraryStorage();
        }
        return savedStorage;
    }

    // TODO
    public boolean saveLibraryData(LibraryStorage storage) {
        try (
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(this.filename, false));
        ) {
            output.writeObject(storage);
            return true;
        }
        catch (IOException ex) {
            return false;
        }
    }
}
