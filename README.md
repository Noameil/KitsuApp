# KitsuApp
HackerU - Final Android Project

![Main Manga Screen](https://github.com/Noameil/KitsuApp/assets/110397935/d1ec063e-88ea-4757-93d2-48f4e16bdf66)

Using 2 RecyclerViews with 2 endpoints:

Each RecyclerView presents different Mangas with minimal info using the endpoints' sorting.

trending/manga - an endpoint that comes with the API without the use of sorting.

manga?sort=PopularityRank - using the API's sorting to get the most popular Mangas by one of the Mangas' attributes - the Popularity Rank.

When clicking on one of the items on the RecyclerView, a bundle is transfered to the Manga Description Screen.

![Main Anime Screen](https://github.com/Noameil/KitsuApp/assets/110397935/2496bab6-a94e-4f81-b78d-1fae29fd4552)

Using 2 RecyclerViews with 2 endpoints:

Each RecyclerView presents different Animes with minimal info using the endpoints' sorting.

trending/anime - an endpoint that comes with the API without the use of sorting.

anime?sort=PopularityRank - using the API's sorting to get the most popular Animes by one of the Animes' attributes - the Popularity Rank.

When clicking on one of the items on the RecyclerView, a bundle is transfered to the Anime Description Screen.

![Manga Description Screen](https://github.com/Noameil/KitsuApp/assets/110397935/052d68bd-f4dd-4499-b3f6-3803524442d6)

The fragment is accepting the bundle from the Manga fragment and presenting the Manga's info in more detail.

![Anime Description Screen](https://github.com/Noameil/KitsuApp/assets/110397935/42e8afa7-14be-42f9-952e-277f9e89f20c)

The fragment is accepting the bundle from the Anime fragment and presenting the Anime's info in more detail.

For Network requests - Using Retrofit

For Database - Using the Kitsu API - https://kitsu.docs.apiary.io/#

[KitsuApp Presentation.pptx](https://github.com/Noameil/KitsuApp/files/11601983/KitsuApp.Presentation.pptx)
