package id.mareno.cataloguemovie.utils

import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults

object DataDummy {
    /*
    fun generateTrendingMovies(): List<TrendingMoviesEntity> {
        val movies = ArrayList<TrendingMoviesEntity>()

        movies.add(
            TrendingMoviesEntity(
                "Brutus vs César",
                "https://m.media-amazon.com/images/M/MV5BM2M2OGJiZTQtOWJkZi00YTdkLWFiOTMtNWZkZDhkOWQ5OTQ1XkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg",
                "2020-09-18",
                "3.6",
                "Faced with the tyranny of Caesar who acts as absolute master over Rome, Senators Rufus and Cassius form a plot to assassinate him",
                "Comedy"
            )

        )
        movies.add(
            TrendingMoviesEntity(
                "Whipped",
                "https://m.media-amazon.com/images/M/MV5BZTU4MGZlNDEtNDU4ZC00OTJiLWI3OWYtZmNjZjMwNzUwYWVmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                "2020-09-18",
                "4.4",
                "Andovi, Tommy, Jovi, and Chandra try to get out of unhealthy relationships because they are \"bucin\" (slaves of love). They decide to take the \"antibucin\" class so they can have a more mature relationship, and not be enslaved by love. It turns out that the method of teaching, taught by Vania, is very extreme. Even threatening their love and friendship relationships.",
                "Comedy, Romance"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "The Paramedic",
                "https://m.media-amazon.com/images/M/MV5BNWE5ODJjNzUtMjk5YS00ZGVhLWI3NWQtNDc5MjU2ZWNhZjllXkEyXkFqcGdeQXVyMTM2Mzg4MA@@._V1_.jpg",
                "2020-09-16",
                "5.6",
                "Angel works in an ambulance service. After a tragic accident, his personal life begins to deteriorate as he becomes more and more suspicious of his partner Vane.",
                "Drama, Thriller"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "Evil Takes Root",
                "https://m.media-amazon.com/images/M/MV5BMTA1ODcwNmQtNDFjMC00ZWQxLWIwNjctZmU2Njc1ZjkwZTM1XkEyXkFqcGdeQXVyNjI2NDU5NDE@._V1_.jpg",
                "2020-09-15",
                "3.9",
                "A paranormal investigator arrives in a sleepy Midwest town to investigate the mysterious loss of his old lover and reconcile sins of the past. He discovers she fell victim to the Batibat, an ancient evil that followed her home from the Philippines.",
                "Horror, Thriller"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "Fear Pharm",
                "https://m.media-amazon.com/images/M/MV5BYzQ5NzU4Y2MtNGYwOC00ZmY2LTk0NmMtOWM0ZjlmMmE4YWE2XkEyXkFqcGdeQXVyMTQ2OTU2OTQ@._V1_.jpg",
                "2020-09-11",
                "3.7",
                "Four people enter a corn maze for Halloween and are picked off one by one by the twisted family who own the scare attraction.",
                "Horror"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "Conjuring the Devil",
                "https://m.media-amazon.com/images/M/MV5BMzM0MjY0YzItMjAwOS00MDdmLWJiM2UtZjQ2MmI0N2UwMDI5XkEyXkFqcGdeQXVyMTA0Mzg1Mjg@._V1_.jpg",
                "2020-09-15",
                "1.9",
                "A woman who is struggling with the conflict between her faith and her personal life must defend herself against the spirit of a demonic nun who is bent on destroying her.",
                "Horror"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "Cats & Dogs 3: Paws Unite",
                "https://m.media-amazon.com/images/M/MV5BYjgzODg2M2ItNzgwMS00ZDRjLWIwMTQtNmQxODE0MjAxY2RkXkEyXkFqcGdeQXVyMzAwNzMwNjY@._V1_.jpg",
                "2020-09-15",
                "4.4",
                "Gwen the Cat and Roger the Dog are secret agents who covertly protect and save the world without humans ever finding out. Their partnership is due to the Great Truce, which has stopped dog and cat hostility for a decade. But the long-standing peace is threatened when a supervillain parrot discovers a way to manipulate wireless frequencies that only dogs and cats can hear. Will the heroes be able to stop the foul fowl, or will he cause a cat-a-strophe between the species?",
                "Action, Comedy, Family, Fantasy"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "Intersect",
                "https://m.media-amazon.com/images/M/MV5BZjUxOTljODQtNDAzMi00NzNkLWI5N2YtMDQ3Yjk0N2FkYmRmXkEyXkFqcGdeQXVyNjcxODY5OQ@@._V1_.jpg",
                "2020-09-15",
                "4.3",
                "A group of young Miskatonic University scientists invent a time machine, only to learn that they are being manipulated by mysterious, unseen forces from another dimension.",
                "Horror, Sci-Fi, Thriller"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "Super Monsters: The New Class",
                "https://m.media-amazon.com/images/M/MV5BMzFlY2U4MDUtMjE0Mi00ZjFmLTgwMzgtMGZlNDliYTE0ZjA3XkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg",
                "2020-08-01",
                "5.9",
                "A new class of pint-sized preschoolers arrives at Pitchfork Pines, and the Super Monsters take their superpowers to the next level - the Purple Room.",
                "Short, Animation, Family"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "Howling Village",
                "https://m.media-amazon.com/images/M/MV5BMzYyOTI1YTctNTUzZi00YTRmLTlmMjctMWQxZmM1NWQ5MmRkXkEyXkFqcGdeQXVyNjc3MjQzNTI@._V1_.jpg",
                "2020-02-07",
                "4.8",
                "The legend and fright of of the Inunaki village of Japan comes back to life. Everything there is cursed and morbid. Moreover, the village actually exists. Enter Kanae a licensed and practicing psychologist who not only is curious vocationally, but herself can communicate with the spirits. She finds herself personally involved when her brother and his girlfriend find themselves in trouble within the limits of Inunaki.",
                "Horror"
            )
        )
        movies.add(
            TrendingMoviesEntity(
                "The Coming",
                "https://m.media-amazon.com/images/M/MV5BMDIwMDc5NzktNzRlNy00MDU2LWIwMTItOGVmOTcwN2Q3OTUwXkEyXkFqcGdeQXVyNzk5ODY5Njk@._V1_.jpg",
                "2020-09-01",
                "2.3",
                "Two young best friends who are forced to stick together as things around them change for the worst. As things begin to fall apart, they realize the events in the book of Revelation are being unveiled right before their very eyes. They soon discover that the book is actually their reality and a guide for what will soon take place. ",
                "Action, Sci-Fi, Thriller"
            )
        )
        return movies
    }

    fun generateTrendingTvs(): List<TrendingMoviesEntity> {
        val crimeMovieShow = ArrayList<TrendingMoviesEntity>()

        crimeMovieShow.add(
            TrendingMoviesEntity(
                "Enola Holmes",
                "https://m.media-amazon.com/images/M/MV5BZjNkNzk0ZjEtM2M1ZC00MmMxLTlmOWEtNWRlZTc1ZTUyNzY4XkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_.jpg",
                "2020-09-23",
                "7.4",
                "England, 1884 - a world on the brink of change. On the morning of her 16th birthday, Enola Holmes (Millie Bobby Brown) wakes to find that her mother (Helena Bonham Carter) has disappeared, leaving behind an odd assortment of gifts but no apparent clue as to where she's gone or why. After a free-spirited childhood, Enola suddenly finds herself under the care of her brothers Sherlock (Henry Cavill) and Mycroft (Sam Claflin), both set on sending her away to a finishing school for \"proper\" young ladies. Refusing to follow their wishes, Enola escapes to search for her mother in London. But when her journey finds her entangled in a mystery surrounding a young runaway Lord (Louis Partridge), Enola becomes a super-sleuth in her own right, outwitting her famous brother as she unravels a conspiracy that threatens to set back the course of history.",
                "Adventure, Crime, Drama, Mystery"
            )
        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "Knives Out",
                "https://m.media-amazon.com/images/M/MV5BMGUwZjliMTAtNzAxZi00MWNiLWE2NzgtZGUxMGQxZjhhNDRiXkEyXkFqcGdeQXVyNjU1NzU3MzE@._V1_.jpg",
                "2019-11-27",
                "7.9",
                "When renowned crime novelist Harlan Thrombey (Christopher Plummer) is found dead at his estate just after his 85th birthday, the inquisitive and debonair Detective Benoit Blanc (Daniel Craig) is mysteriously enlisted to investigate. From Harlan's disfunctional family to his devoted staff, Blanc sifts through a web of red herrings and self-serving lies to uncover the truth behind Harlan's untimely death.",
                "Comedy, Crime, Drama, Mystery, Thriller"
            )
        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "Ava",
                "https://m.media-amazon.com/images/M/MV5BMTMzMTg1MjgtOWNhYy00NmZmLWExOTctMjA2OTZhZDFkNDhhXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1_.jpg",
                "2020-09-25",
                "5.3",
                "Ava is a deadly assassin who works for a black ops organization, traveling the globe specializing in high profile hits. When a job goes dangerously wrong she is forced to fight for her own survival.",
                "Action, Crime, Drama, Thriller"
            )
        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "Joker",
                "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "2019-10-04",
                "8.5",
                "Arthur Fleck works as a clown and is an aspiring stand-up comic. He has mental health issues, part of which involves uncontrollable laughter. Times are tough and, due to his issues and occupation, Arthur has an even worse time than most. Over time these issues bear down on him, shaping his actions, making him ultimately take on the persona he is more known as...Joker.",
                "Crime, Drama, Thriller"
            )
        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "Zodiac",
                "https://m.media-amazon.com/images/M/MV5BN2UwNDc5NmEtNjVjZS00OTI5LWE5YjctMWM3ZjBiZGYwMGI2XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
                "2007-03-02",
                "7.7",
                "A serial killer in the San Francisco Bay Area taunts police with his letters and cryptic messages. We follow the investigators and reporters in this lightly fictionalized account of the true 1970's case as they search for the murderer, becoming obsessed with the case. Based on Robert Graysmith's book, the movie's focus is the lives and careers of the detectives and newspaper people.",
                "Crime, Drama, Mystery, Thriller"
            )

        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "The Dark Knight",
                "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg",
                "2008-07-18",
                "9.0",
                "Set within a year after the events of Batman Begins (2005), Batman, Lieutenant James Gordon, and new District Attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City, until a mysterious and sadistic criminal mastermind known only as \"The Joker\" appears in Gotham, creating a new wave of chaos. Batman's struggle against The Joker becomes deeply personal, forcing him to \"confront everything he believes\" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent, and Rachel Dawes.",
                "Action, Crime, Drama, Thriller"
            )
        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "Harley Quinn: Birds of Prey",
                "https://m.media-amazon.com/images/M/MV5BMzQ3NTQxMjItODBjYi00YzUzLWE1NzQtZTBlY2Y2NjZlNzkyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "2020-02-07",
                "6.1",
                "A twisted tale told by Harley Quinn herself, when Gotham's most nefariously narcissistic villain, Roman Sionis, and his zealous right-hand, Zsasz, put a target on a young girl named Cass, the city is turned upside down looking for her. Harley, Huntress, Black Canary and Renee Montoya's paths collide, and the unlikely foursome have no choice but to team up to take Roman down.",
                "Action, Adventure, Crime"
            )
        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "The Devil All the Time",
                "https://m.media-amazon.com/images/M/MV5BZmE1NmVmN2EtMjZmZC00YzAyLWE4MWEtYjY5YmExMjUxODU1XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "2020-09-16",
                "7.2",
                "Set in rural southern Ohio and West Virginia, The Devil All the Time follows a cast of compelling and bizarre characters from the end of World War II to the 1960s. There's Willard Russell, tormented veteran of the carnage in the South Pacific, who can't save his beautiful wife, Charlotte, from an agonizing death by cancer no matter how much sacrificial blood he pours on his \"prayer log.\" There's Carl and Sandy Henderson, a husband-and-wife team of serial killers, who troll America's highways searching for suitable models to photograph and exterminate. There's the spider-handling preacher Roy and his crippled virtuoso-guitar-playing sidekick, Theodore, running from the law. And caught in the middle of all this is Arvin Eugene Russell, Willard and Charlotte's orphaned son, who grows up to be a good but also violent man in his own right.",
                "Crime, Drama, Thriller"
            )
        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "The Gentlemen",
                "https://m.media-amazon.com/images/M/MV5BMTlkMmVmYjktYTc2NC00ZGZjLWEyOWUtMjc2MDMwMjQwOTA5XkEyXkFqcGdeQXVyNTI4MzE4MDU@._V1_.jpg",
                "2020-01-24",
                "7.9",
                "A talented American graduate of Oxford, using his unique skills, and audacity, creates a marijuana empire using the estates of impoverished British aristocrats. However, when he tries to sell his empire to a fellow American billionaire, a chain of events unfolds, involving blackmail, deception, mayhem and murder between street thugs, Russian oligarchs, Triad gangsters and gutter journalists.",
                "Action, Comedy, Crime"
            )
        )
        crimeMovieShow.add(
            TrendingMoviesEntity(
                "21 Bridges",
                "https://m.media-amazon.com/images/M/MV5BYTg4YzEzNDQtZDAxOS00M2YyLTljZWEtNjk4YTc4NDM2NTBhXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                "2019-11-22",
                "6.6",
                "Thrust into a citywide manhunt for a duo of cop killers, NYPD detective Andre Davis begins to uncover a massive conspiracy that links his fellow police officers to a criminal empire and must decide who he is hunting and who is actually hunting him. During the manhunt, Manhattan is completely locked down for the first time in its history - no exit or entry to the island including all 21 bridges.",
                "Action, Crime, Drama, Thriller"
            )
        )

        return crimeMovieShow
    }

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
        val fakeGenres: List<String>? = listOf("28", "12", "16")

        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )
        movie.add(
            TrendingMovieResults(
                fakeGenres,
                56787,
                "test overview",
                "poster",
                "19-07-1998",
                "Fake Title",
                7.8
            )
        )

        return movie
    }

    fun generateRemoteTrendingTvs(): List<TrendingTvResults> {
        val movie = ArrayList<TrendingTvResults>()
        val fakeGenres: List<Int>? = listOf(28, 12, 16)

        movie.add(
            TrendingTvResults(
                "19-01-2020",
                fakeGenres,
                67859,
                "Fake Title",
                "Fake Overview",
                "Fake Posterpath",
                7.8
            )
        )
        movie.add(
            TrendingTvResults(
                "19-01-2020",
                fakeGenres,
                67859,
                "Fake Title",
                "Fake Overview",
                "Fake Posterpath",
                7.8
            )
        )
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
}
