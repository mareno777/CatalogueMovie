package id.mareno.cataloguemovie.model.json


import id.mareno.cataloguemovie.model.responses.SearchMovieResults

data class SearchMovieModel(
    var results: List<SearchMovieResults>
)