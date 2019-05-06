package com.lostfound.pojo.Increase;

import com.lostfound.pojo.Pick;
import org.springframework.web.multipart.MultipartFile;

public class PickIncrease extends Pick {
    private MultipartFile file;
    private MultipartFile file2;
    private MultipartFile file3;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile2() {
        return file2;
    }

    public void setFile2(MultipartFile file2) {
        this.file2 = file2;
    }

    public MultipartFile getFile3() {
        return file3;
    }

    public void setFile3(MultipartFile file3) {
        this.file3 = file3;
    }

}
