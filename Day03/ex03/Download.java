import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Download implements Runnable {

    public String Name;
    public UrlsList urls;

    public Download(String name, UrlsList Urls) {
        this.Name = name;
        this.urls = Urls;
    }

    public void startmsg(int number) {
        System.out.printf("%s start download file number %d\n", this.Name, number);
    }

    private void finishmsg(int number) {
        System.out.printf("%s finish download file number %d\n", this.Name, number);
    }

    public void run() {

        while (urls.getsize() > 0) {
            try {
                String filename = urls.download();

                if (filename != null) {
                    startmsg(urls.getUrlsCount(filename));

                    BufferedInputStream in = new BufferedInputStream(new URL(filename).openStream());
                    String[] namesArray = filename.split("/");
                    FileOutputStream out = new FileOutputStream(namesArray[namesArray.length - 1]);
                    byte[] buffer = new byte[4096];
                    int bytes;

                    while ((bytes = in.read(buffer, 0, 4096)) != -1) {
                        out.write(buffer, 0, bytes);
                    }

                    out.close();
                    in.close();
                    finishmsg(urls.getUrlsCount(filename));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
