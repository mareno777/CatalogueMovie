package id.mareno.cataloguemovie.utils

import id.mareno.cataloguemovie.model.entities.list.PopularMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.PopularTvsEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingTvsEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults

object DataDummy {

    fun generateTrendingMovies(): List<TrendingMoviesEntity> {
        val movies = ArrayList<TrendingMoviesEntity>()

        for (i in 0 until 21) {
            movies.add(
                TrendingMoviesEntity(
                    i,
                    "https://m.media-amazon.com/images/M/MV5BM2M2OGJiZTQtOWJkZi00YTdkLWFiOTMtNWZkZDhkOWQ5OTQ1XkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg",
                    "dummyTitle"
                )

            )
        }

        return movies
    }

    fun generateTrendingTvs(): List<TrendingTvsEntity> {
        val tvShow = ArrayList<TrendingTvsEntity>()

        for (i in 0 until 21) {
            tvShow.add(
                TrendingTvsEntity(
                    i,
                    "title $i",
                    "posterpath"
                )
            )
        }
        return tvShow
    }

    /*
    fun generatePopularMovies(): List<TrendingMoviesEntity> {
        val popularMovie = ArrayList<TrendingMoviesEntity>()

        popularMovie.add(
            TrendingMoviesEntity(
                "Mulan",
                "https://m.media-amazon.com/images/M/MV5BNDliY2E1MjUtNzZkOS00MzJlLTgyOGEtZDg4MTI1NzZkMTBhXkEyXkFqcGdeQXVyNjMwMzc3MjE@._V1_.jpg",
                "2020-09-04",
                "5.4",
                "A young Chinese maiden disguises herself as a male warrior in order to save her father.",
                "Action, Adventure, Drama, Family"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "Dune",
                "https://m.media-amazon.com/images/M/MV5BMGFkZGY0NTgtMGEyZC00YzhjLTkyOWItYzMzOTljMDA3ZjU2XkEyXkFqcGdeQXVyNzc4NTU3Njg@._V1_.jpg",
                "2020-12-18",
                "N/A",
                "A mythic and emotionally charged hero's journey, \"Dune\" tells the story of Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                "Adventure, Drama, Sci-Fi"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "Tenet",
                "https://m.media-amazon.com/images/M/MV5BYzg0NGM2NjAtNmIxOC00MDJmLTg5ZmYtYzM0MTE4NWE2NzlhXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_.jpg",
                "2020-09-03",
                "7.8",
                "In a twilight world of international espionage, an unnamed CIA operative, known as The Protagonist, is recruited by a mysterious organization called Tenet to participate in a global assignment that unfolds beyond real time. The mission: prevent Andrei Sator, a renegade Russian oligarch with precognition abilities, from starting World War III. The Protagonist will soon master the art of \"time inversion\" as a way of countering the threat that is to come.",
                "Action, Sci-Fi"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "I'm Thinking of Ending Things",
                "https://m.media-amazon.com/images/M/MV5BNWMyZTA1MTItMzFhOS00NGY5LWJlZDMtMzczZmRjOThkMmViXkEyXkFqcGdeQXVyMjUxMTY3ODM@._V1_.jpg",
                "2020-09-04",
                "6.7",
                "Despite second thoughts about their relationship, a young woman (Jessie Buckley) takes a road trip with her new boyfriend (Jesse Plemons) to his family farm. Trapped at the farm during a snowstorm with Jake's mother (Toni Collette) and father (David Thewlis), the young woman begins to question the nature of everything she knew or understood about her boyfriend, herself, and the world. An exploration of regret, longing and the fragility of the human spirit, I'M THINKING OF ENDING THINGS is directed and written by Academy Award® winner Charlie Kaufman (Eternal Sunshine of the Spotless Mind). Inspired by Iain Reid's bestselling namesake novel.",
                "Drama, Thriller"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "Cuties",
                "https://m.media-amazon.com/images/M/MV5BYzZiMTMzMDUtMzVmOS00ODZjLThiNDQtNmY2NzIxZjBmZGM4XkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg",
                "2020-09-09",
                "2.6",
                "Amy, an 11-year-old girl, joins a group of dancers named \"the cuties\" at school, and rapidly grows aware of her burgeoning femininity - upsetting her mother and her values in the process.",
                "Drama"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "No Time to Die",
                "https://m.media-amazon.com/images/M/MV5BMjI4NTI0ODMtYjQzZC00YzljLWE3YzUtM2MzMmNmZjA1Y2JiXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "2020-11-20",
                "N/A",
                "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.",
                "Action, Adventure, Thriller"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "The Karate Kid",
                "https://m.media-amazon.com/images/M/MV5BNTkzY2YzNmYtY2ViMS00MThiLWFlYTEtOWQ1OTBiOGEwMTdhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg",
                "1984-06-22",
                "7.2",
                "Daniel and his mother move from New Jersey to California. She has a wonderful new job, but Daniel quickly discovers that a dark haired Italian boy with a Jersey accent doesn't fit into the blond surfer crowd. Daniel manages to talk his way out of some fights, but he is finally cornered by several who belong to the same karate school. As Daniel is passing out from the beating he sees Miyagi, the elderly gardener leaps into the fray and save him by outfighting half a dozen teenagers. Miyagi and Daniel soon find out the real motivator behind the boys' violent attitude in the form of their karate teacher. Miyagi promises to teach Daniel karate and arranges a fight at the all-valley tournament some months off. When his training begins, Daniel doesn't understand what he is being shown. Miyagi seems more interested in having Daniel paint fences and wax cars than teaching him Karate.",
                "Action, Drama, Family, Sport"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "The Babysitter: Killer Queen",
                "https://m.media-amazon.com/images/M/MV5BMWEwMDU3MWUtZTdiMy00Yjg5LWFiNWYtYTRmZGExNzk5YjQ2XkEyXkFqcGdeQXVyNTUwOTkzMzY@._V1_.jpg",
                "2020-09-10",
                "5.9",
                "Two years after Cole survived a satanic blood cult, he's living another nightmare: high school. And the demons from his past? Still making his life hell.",
                "Comedy, Horror"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "After We Collided",
                "https://m.media-amazon.com/images/M/MV5BN2UyNGM3MDUtMTIzZi00ZDdkLThlYTktYjk0ZDMzM2JiMjMyXkEyXkFqcGdeQXVyNzE0MjkxMzA@._V1_.jpg",
                "2020-10-23",
                "5.5",
                "Tessa has everything to lose. Hardin has nothing to lose. - except her. After We Collided - Life will never be the same. After a tumultuous beginning to their relationship, Tessa and Hardin were on the path to making things work. Tessa knew Hardin could be cruel, but when a bombshell revelation is dropped about the origins of their relationship - and Hardin's mysterious past - Tessa is beside herself. Hardin will always be - Hardin. But is he really the deep, thoughtful guy Tessa fell madly in love with despite his angry exterior - or has he been a stranger all along? She wishes she could walk away. It's just not that easy. Hardin knows he made a mistake, possibly the biggest one of his life. He's not going down without a fight. But can he change? Will he change - for love? Yes, yes he will.",
                "Drama, Romance"
            )
        )
        popularMovie.add(
            TrendingMoviesEntity(
                "Bill & Ted Face the Music",
                "https://m.media-amazon.com/images/M/MV5BOTRiNzFhNjAtNTdhMS00ZjViLWFhNTUtMWJlMTJkMGM1YzM4XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "2020-08-28",
                "6.3",
                "Once told they'd save the universe during a time-traveling adventure, 2 would-be rockers from San Dimas, California find themselves as middle-aged dads still trying to crank out a hit song and fulfill their destiny.",
                "Adventure, Comedy, Music, Sci-Fi"
            )
        )

        return popularMovie
    }

    fun generatePopularTvShows(): List<TrendingMoviesEntity> {
        val popularTvShow = ArrayList<TrendingMoviesEntity>()

        popularTvShow.add(
            TrendingMoviesEntity(
                "The Boys",
                "https://m.media-amazon.com/images/M/MV5BNGEyOGJiNWEtMTgwMi00ODU4LTlkMjItZWI4NjFmMzgxZGY2XkEyXkFqcGdeQXVyNjcyNjcyMzQ@._V1_.jpg",
                "2019-07-26",
                "8.7",
                "The Boys is set in a universe in which superpowered people are recognized as heroes by the general public and owned by a powerful corporation, Vought International, which ensures that they are aggressively marketed and monetized. Outside of their heroic personas, most are arrogant and corrupt. The series primarily focuses on two groups: the titular Boys, vigilantes looking to keep the corrupted heroes under control, and the Seven, Vought International's premier superhero team. The Boys are led by Billy Butcher, who despises all superpowered people, and the Seven are led by the egotistical and unstable Homelander. As a conflict ensues between the two groups, the series also follows the new members of each team: Hugh \"Hughie\" Campbell of the Boys, who joins the vigilantes after his girlfriend is killed in a high-speed collision by the Seven's A-Train, and Annie January/Starlight of the Seven, a young and hopeful heroine forced to face the truth about the heroes she admires.",
                "Action, Comedy, Crime, Sci-Fi",
                "17"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "Cobra Kai",
                "https://m.media-amazon.com/images/M/MV5BYTI3NjcxNjctNzZhZS00NjQwLTg4NDEtMmQzOGJiYTUwNWFjXkEyXkFqcGdeQXVyOTA5NzQ0MDQ@._V1_.jpg",
                "2018-05-02",
                "8.7",
                "Thirty years after their final confrontation at the 1984 All Valley Karate Tournament, Johnny Lawrence is at rock-bottom as an unemployed handyman haunted by his wasted life. However, when Johnny rescues a bullied kid, Miguel, from bullies, he is inspired to restart the notorious Cobra Kai dojo. However, this revitalization of his life and related misunderstandings find Johnny restarting his old rivalry with Daniel LaRousso, a successful businessman who may be happily married, but is missing an essential balance in life since the death of his mentor, Mr. Miyagi. Meanwhile, even as this antipathy festers, it finds itself reflected in their protegees as Miguel and his comrades are gradually poisoned by Cobra Kai's thuggish philosophy. Meanwhile, while Daniel's daughter, Samantha, finds herself in the middle of this conflict amidst false friends, Johnny's estranged miscreant son, Robby, finds himself inadvertently coming under Daniel's wing and flourishes in ways worthy of Mr. Miyagi.",
                "Action, Comedy, Drama, Sport",
                "30"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "Raised by Wolves",
                "https://m.media-amazon.com/images/M/MV5BZWM2NmIwZjQtZTEwYS00MmVhLTgzODItMGU3OWRkN2UxM2YyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "2020-09-03",
                "8.5",
                "Androids are tasked with raising human children on a mysterious planet.",
                "Drama, Fantasy, Sci-Fi, Thriller",
                "11"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "Ratched",
                "https://m.media-amazon.com/images/M/MV5BMDJiZGE5NzYtZGU3Zi00NDQwLWFhMjAtNTM0MDM2ZTljMjAzXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "2020-09-18",
                "7.6",
                "In 1947, Mildred Ratched begins working as a nurse at a leading psychiatric hospital. But beneath her stylish exterior lurks a growing darkness.",
                "Crime, Drama, Mystery, Thriller",
                "18"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "The Mandalorian",
                "https://m.media-amazon.com/images/M/MV5BZDhlMzY0ZGItZTcyNS00ZTAxLWIyMmYtZGQ2ODg5OWZiYmJkXkEyXkFqcGdeQXVyODkzNTgxMDg@._V1_.jpg",
                "2019-11-12",
                "8.7",
                "After the stories of Jango and Boba Fett, another warrior emerges in the Star Wars universe. The Mandalorian is set after the fall of the Empire and before the emergence of the First Order. We follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic.",
                "Action, Adventure, Sci-Fi",
                "17"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "Away",
                "https://m.media-amazon.com/images/M/MV5BZDg0NDAxOTctZjdmNy00ODVjLTgyMDItZjFmMjdjYTk3ZTYxXkEyXkFqcGdeQXVyNjEwNTM2Mzc@._V1_.jpg",
                "2020-09-04",
                "6.6",
                "An American astronaut struggles with leaving her husband and daughter behind to embark on a dangerous mission with an international space crew.",
                "Drama, Romance, Sci-Fi",
                "10"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "Lucifer",
                "https://m.media-amazon.com/images/M/MV5BNzY1YjIxOGMtOTAyZC00YTcyLWFhMzQtZTJkYTljYzU0MGRlXkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg",
                "N/A",
                "8.2",
                "Lucifer Morningstar, bored from his sulking life in hell, comes to live in Los Angeles. While there, he helps humanity with its miseries through his experience and telepathic abilities to bring people's deepest desires and thoughts out of them. While meeting with a Detective in his nightclub (Lux), a shootout involving him and the Detective leads him to become an LAPD consultant who tries to punish people for their crimes through law and justice.",
                "Crime, Drama, Fantasy",
                "93"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "Des",
                "https://m.media-amazon.com/images/M/MV5BNjVkZGVlNzItM2FhOC00MWFhLThkYjUtNWE0MDNkNGMxMzk3XkEyXkFqcGdeQXVyNjEwNTM2Mzc@._V1_.jpg",
                "2020-09-14",
                "8.0",
                "In 1983 Scottish serial killer Dennis Nilsen is arrested after the discovery of human remains which have blocked a drain near his London home.",
                "Crime, Drama, History, Thriller",
                "3"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "Lovecraft Country",
                "https://m.media-amazon.com/images/M/MV5BM2ExMmZlZDQtOTJiZC00Y2UzLWIxNDYtZTdiYzAzYzQyMmQ4XkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg",
                "2020-08-16",
                "7.3",
                "Lovecraft Country follows Atticus Freeman as he joins up with his friend Letitia and his Uncle George to embark on a road trip across 1950s Jim Crow America in search of his missing father. This begins a struggle to survive and overcome both the racist terrors of white America and the terrifying monsters that could be ripped from a Lovecraft paperback.",
                "Drama, Fantasy, Horror, Mystery, Sci-Fi, Thriller",
                "10"
            )
        )
        popularTvShow.add(
            TrendingMoviesEntity(
                "The Umbrella Academy",
                "https://m.media-amazon.com/images/M/MV5BNzA5MjkwYzMtNGY2MS00YWRjLThkNTktOTNmMzdlZjE3Y2IxXkEyXkFqcGdeQXVyMjkwMzMxODg@._V1_.jpg",
                "2019-02-15",
                "8.0",
                "On the same day in October 1989, forty-three infants are inexplicably born to random, unconnected women who showed no signs of pregnancy the day before. Seven are adopted by Sir Reginald Hargreeves, a billionaire industrialist, who creates The Umbrella Academy and prepares his \"children\" to save the world. But not everything went according to plan. In their teenage years, the family fractured and the team disbanded. Now, the six surviving thirty-something members reunite upon the news of Hargreeves' passing. Luther, Diego, Allison, Klaus, Vanya and Number Five work together to solve a mystery surrounding their father's death. But the estranged family once again begins to come apart due to their divergent personalities and abilities, not to mention the imminent threat of a global apocalypse.",
                "Action, Adventure, Comedy, Drama, Fantasy, Sci-Fi",
                "20"
            )
        )

        return popularTvShow
    }

     */


    fun generateRemoteTrendingMovies(): List<TrendingMovieResults> {
        val movie = ArrayList<TrendingMovieResults>()
        for (i in 0 until 21) {

            movie.add(
                TrendingMovieResults(
                    i,
                    "poster",
                    "title",
                )
            )
        }

        return movie
    }

    fun generateRemoteTrendingTvs(): List<TrendingTvResults> {
        val movie = ArrayList<TrendingTvResults>()
        for (i in 0 until 21) {
            movie.add(
                TrendingTvResults(
                    i,
                    "title $i",
                    "posterpath"
                )
            )
        }
        return movie
    }

    fun generateRemotePopularMovies(): List<PopularMovieResults> {
        val movie = ArrayList<PopularMovieResults>()

        for (i in 0 until 21) {

            movie.add(
                PopularMovieResults(
                    i,
                    "poster",
                    "Fake Title",
                )
            )
        }
        return movie
    }

    fun generateRemotePopularTvs(): List<PopularTvResults> {
        val movie = ArrayList<PopularTvResults>()

        for (i in 0 until 21) {

            movie.add(
                PopularTvResults(
                    i,
                    "tilte",
                    "poster",
                )
            )
        }
        return movie

    }

    fun generatePopularTvs(): List<PopularTvsEntity> {
        val movie = ArrayList<PopularTvsEntity>()

        for (i in 0 until 21) {

            movie.add(
                PopularTvsEntity(
                    i,
                    "tilte",
                    "poster",
                )
            )
        }
        return movie

    }

    fun generatePopularMovies(): List<PopularMoviesEntity> {
        val movie = ArrayList<PopularMoviesEntity>()

        for (i in 0 until 21) {

            movie.add(
                PopularMoviesEntity(
                    i,
                    "tilte",
                    "poster",
                )
            )
        }
        return movie
    }
}
