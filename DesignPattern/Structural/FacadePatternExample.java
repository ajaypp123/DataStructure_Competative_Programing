

// Multiple classes with same interface
interface Browser {
    public String getDriver();
    public void generateJunitReport(String msg, String driver);
    public void generateHtmlReport(String msg, String driver);
}

class ChromeBrowser implements Browser{
    @Override
    public String getDriver() {
        return "Chrome Driver";
    }

    @Override
    public void generateJunitReport(String msg, String driver) {
        System.out.println("Generate JunitReport: msg: " + msg +", driver: " + driver);
    }

    @Override
    public void generateHtmlReport(String msg, String driver) {
        System.out.println("Generate HtmlReport: msg: " + msg +", driver: " + driver);
    }
}

class FirefoxBrowser implements Browser{
    @Override
    public String getDriver() {
        return "Chrome Driver";
    }

    @Override
    public void generateJunitReport(String msg, String driver) {
        System.out.println("Generate JunitReport: msg: " + msg +", driver: " + driver);
    }

    @Override
    public void generateHtmlReport(String msg, String driver) {
        System.out.println("Generate HtmlReport: msg: " + msg +", driver: " + driver);
    }
}

// Facade
class WebRouting {

    static Browser b;
    static String driver;

    public static void generateReports(String browser, String report_type, String test) {
        switch (browser) {
            case "chrome":
                b = new ChromeBrowser();
                driver = b.getDriver();
                switch (report_type) {
                    case "html":
                        b.generateHtmlReport(test, driver);
                        break;
                    case "junit":
                        b.generateJunitReport(test, driver);
                        break;
                    default:
                        System.out.println("Invalid report type");
                        break;
                }
                break;
            case "firefox":
                b = new FirefoxBrowser();
                driver = b.getDriver();
                switch (report_type) {
                    case "html":
                        b.generateHtmlReport(test, driver);
                        break;
                    case "junit":
                        b.generateJunitReport(test, driver);
                        break;
                    default:
                        break;
                }
                break;

            default:
                break;
        }
    }
}

public class FacadePatternExample {
    public static void main(String[] args) {
        WebRouting.generateReports("chrome", "html", "TestedThisChrome");
    }
}
