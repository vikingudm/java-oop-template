package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = {};

    @Override
    public boolean save(SchoolBook book) {
        SchoolBook[] tempSchoolBooks = new SchoolBook[schoolBooks.length + 1];
        System.arraycopy(schoolBooks, 0, tempSchoolBooks, 0, schoolBooks.length);
        tempSchoolBooks[tempSchoolBooks.length - 1] = book;
        schoolBooks = tempSchoolBooks;
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        for (SchoolBook schoolBook : schoolBooks) {
            if (name.equals(schoolBook.getName())) {
                return schoolBooks;
            }
        }
        return new SchoolBook[0];
    }

    @Override
    public boolean removeByName(String name) {
        int size = 0;
        for (SchoolBook schoolBook : schoolBooks) {
            if (name.equals(schoolBook.getName())) {
                size++;
            }
        }
        SchoolBook[] tempSchoolBooks = new SchoolBook[schoolBooks.length - size];
        for (SchoolBook schoolBook : schoolBooks) {
            if (!name.equals(schoolBook.getName())) {
                Arrays.fill(tempSchoolBooks, schoolBook);
            }
            schoolBooks = tempSchoolBooks;
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}