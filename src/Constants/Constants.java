package Constants;

/**
 * Created by josef on 2016-12-03.
 */
public class Constants {
    public static final int WINDOWHEIGHT = 1080;
    public static final int WINDOWWIDTH = 1920;
    public static final String IMAGEFOLDERPATH = "./images/";
    public static final String INFOFILEPATH = "./files/info.json";
    public static final String MAPFOLDERPATH = "./files/maps";

    public static final int CHUNKSWIDTH = 12;
    public static final int CHUNKSHEIGHT = 8;
    public static final int PIXELSPERCHUNKS = 30;
    public static final int PIXELSIZE = WINDOWWIDTH / (CHUNKSWIDTH * PIXELSPERCHUNKS);

    public static final int TILESIZE = 30;

    public static final float BASESPEED = (float) 0.4;

    //Standard varelsen ska vara under 40 x 40 pixlar.

}
