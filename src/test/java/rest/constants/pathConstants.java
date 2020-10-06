package rest.constants;

import java.io.File;

public class pathConstants {
    private pathConstants(){}
    public static final String FIXTURES_PATH = System.getProperty("user.dir")+File.separator +"src"+File.separator+"test"+File.separator+"java"+ File.separator+"rest"+File.separator+"fixtures";
    public static final String ENV_FILE = System.getProperty("user.dir")+File.separator +"src"+File.separator+"test"+File.separator+"java"+ File.separator+"rest"+File.separator+"env";
    public static final String FEATURE_PATH = System.getProperty("user.dir")+File.separator +"src"+File.separator+"test"+File.separator+"resources"+File.separator+"features";
}