public class TranslateRunner implements Runnable {
    String url;
    String path;
    String TEMP_DIR;

    public TranslateRunner(String url, String path){
        this.url = url;
        this.path = path;
        TEMP_DIR = "temp";
    }

    @Override
    public void run() {
        try{
            new HTMLParserTool(url, TEMP_DIR, path).run();
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}