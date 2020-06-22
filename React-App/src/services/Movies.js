import React, { Component } from 'react';
import MovieList from '../components/organisms/MovieList';
import MovieService from './MovieService';

export default class Movies extends Component {

    constructor() {
        super();
        this.state = {
            movies: []
        };
    }

    componentDidMount() {
        this.setState(() => ({ movies: MovieService.getMovies() }));
    }

    render() {  
        return (
            <div className="container-fluid" style={{marginLeft: '-15px'}}>
                        <MovieList movies={this.state.movies} />
            </div>
        );
    }
}