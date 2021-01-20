package imageviewer.apps;

import imageviewer.model.Image;
import imageviewer.view.ImageLoader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileImageLoader implements ImageLoader {
    private final File root;

    public FileImageLoader(File root) {
        this.root = root;
    }
    
    @Override
    public List<Image> load() {
        List<Image> res = new ArrayList<>();
        for (File file : root.listFiles(filter())) {
            res.add(new Image(file.getAbsolutePath()));
        }
        return res;
    }

    private static final String[] ImageExtensions = new String[] {"jpg", "png", "jpeg"};
    private FilenameFilter filter() {
        return new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                for (String extension : ImageExtensions) {
                    if(name.endsWith(extension)) return true;
                }
                return false;
            }
        };
    }
    
}
