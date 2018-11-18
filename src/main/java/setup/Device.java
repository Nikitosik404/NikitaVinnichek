package setup;

public class Device {
    public String aut;
    public String sut;
    public String test_platform;
    public String driver;
    public String device_name;
    public String udid;
    public String app_package;
    public String app_activity;

    public boolean isRemote;


    @Override
    public String toString() {
        return "Device{" +
                "aut='" + aut + '\'' +
                ", sut='" + sut + '\'' +
                ", test_platform='" + test_platform + '\'' +
                ", driver='" + driver + '\'' +
                ", device_name='" + device_name + '\'' +
                ", isRemote=" + isRemote +
                ", udid='" + udid + '\'' +
                ", app_package='" + app_package + '\'' +
                ", app_activity='" + app_activity + '\'' +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
