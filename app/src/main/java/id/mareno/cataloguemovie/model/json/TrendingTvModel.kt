package id.mareno.cataloguemovie.model.json


import id.mareno.cataloguemovie.model.responses.TrendingTvResults

data class TrendingTvModel(
    var results: ArrayList<TrendingTvResults>
)