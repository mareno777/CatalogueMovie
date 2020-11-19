package id.mareno.cataloguemovie.model.json


import id.mareno.cataloguemovie.model.responses.ComingSoonMovieResults

data class ComingSoonModel(
    var results: ArrayList<ComingSoonMovieResults>?
)