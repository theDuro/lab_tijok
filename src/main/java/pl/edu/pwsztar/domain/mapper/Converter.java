package pl.edu.pwsztar.domain.mapper;
    @FunctionalInterface
    interface Converter<T, F> {
        T convert(F from);
    }


