package id.mareno.cataloguemovie.model.json


import id.mareno.cataloguemovie.model.responses.PopularTvResults

data class PopularTvModel(
    var results: ArrayList<PopularTvResults>?
)