package id.mareno.cataloguemovie.model.json

import id.mareno.cataloguemovie.model.responses.PopularMovieResults

data class PopularMovieModel(
    val results: List<PopularMovieResults>
)