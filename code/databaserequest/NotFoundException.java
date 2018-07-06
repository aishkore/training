package com.example.demo;

import java.util.NoSuchElementException;

final class NotFoundException extends NoSuchElementException {

private final Object entity;

private NotFoundException(final Object entity) {
this.entity = entity;
}

static NotFoundException notFoundException(final Object entity) {
return new NotFoundException(entity);
}

Object getEntity() {
return entity;
}

}