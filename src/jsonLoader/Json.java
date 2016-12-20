package jsonLoader;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by josef on 2016-12-20.
 */
public class Json {

    private static String load(String filePath) throws FileNotFoundException {
        return new Scanner(new FileReader(filePath)).useDelimiter("\\Z").next();
    }

    public static <T extends Class> T parse(String filePath, T clazz) throws FileNotFoundException {
        return (T) new Gson().fromJson(load(filePath), clazz);
    }
}
