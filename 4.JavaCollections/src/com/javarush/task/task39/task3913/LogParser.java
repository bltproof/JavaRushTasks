package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements IPQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    private List<Path> listSourceFiles(Path dir) throws IOException {
        List<Path> result = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.log")) {
            for (Path entry : stream) {
                result.add(entry);
            }
        } catch (DirectoryIteratorException ex) {
            throw ex.getCause();
        }
        return result;
    }

    public boolean getNumberOfUniqueIPs(Object o, Date date) {
        return false;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();

        try {
            for (Path p : listSourceFiles(logDir)) {
                set.addAll(Files.lines(p).map(s -> s.substring(0, s.indexOf("\t"))).collect(Collectors.toSet()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return set;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}