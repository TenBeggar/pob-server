package com.tenbeggar.pob.utils;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Extractor {

    public static void extractTGZ(File sourceFile, File targetFolder) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             GzipCompressorInputStream gzipCompressorInputStream = new GzipCompressorInputStream(bufferedInputStream);
             TarArchiveInputStream tarArchiveInputStream = new TarArchiveInputStream(gzipCompressorInputStream)) {

            ArchiveEntry entry;
            while ((entry = tarArchiveInputStream.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    continue;
                }

                File entryFile = new File(targetFolder, entry.getName());
                File entryParent = entryFile.getParentFile();

                if (!entryParent.exists() && !entryParent.mkdirs()) {
                    throw new IOException("Failed to create parent directory: " + entryParent);
                }

                Files.copy(tarArchiveInputStream, entryFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
