package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = {};

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            Author[] tempAuthor = new Author[authors.length + 1];
            System.arraycopy(authors, 0, tempAuthor, 0, authors.length);
            tempAuthor[tempAuthor.length - 1] = author;
            authors = tempAuthor;
            return true;
        }
        return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author author : authors) {
            if ((name + lastname).equals(author.getName() + author.getLastName())) {
                return author;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        int size = 0;
        for (Author value : authors) {
            if (author.getName().equals(value.getName()) && author.getLastName().equals(value.getLastName())) {
                size++;
            }
        }
        Author[] tempAuthors = new Author[authors.length - size];
        for (Author value : authors) {
            if (author.getName().equals(value.getName()) && author.getLastName().equals(value.getLastName())) {
                Arrays.fill(tempAuthors, author);
            }
            authors = tempAuthors;
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
