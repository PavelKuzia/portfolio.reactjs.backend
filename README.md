## RESTFul API Backend for portfolio projects ##
***

### Description ###

This project provides API for keeping trend over movie trends

### Endpoints ###
#### GET ####
* /trends : returns all trends (number of search requests for movies)
* trends/query?searchTerm= : returns all movies in trends
where search term consists of searchTerm
#### POST ####
/trends : adds a new trend to database
#### PUT ####
/trends/{id} : updated a counter of searches for a movie with id