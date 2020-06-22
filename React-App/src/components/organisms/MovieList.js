import React ,{Component} from 'react';
import MovieCard from '../molecules/MovieCard';
import SearchBar from '../atoms/SearchBar';
 export default class MovieList extends Component{
     constructor(){
         super();
         this.state={
             search:''
         }
     }

    updateSearch = (event) => {
        this.setState({search: event.target.value});
    }

    render(){
        let filteredMovies=this.props.movies.filter(
            (movie) => {
                return movie.title.toLowerCase().indexOf(this.state.search.toLowerCase()) !== -1;
            }
        );
        return(
            <div>
                <SearchBar value={this.state.search} changed={this.updateSearch} />
                <div className="card-deck">
                {
                    filteredMovies.map(movie => <MovieCard key={movie.id} movie={movie} />)
                }
            </div>
            </div>
        )
            }
    }

