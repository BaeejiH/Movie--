import {createStore} from 'vuex'

const store= createStore ({
    state(){
        return{
        user: {},
        selectMovie:{}
      }
    },
    mutations:{
        setUser(state,value){
            state.user =value;
        },
        setMovie(state,movie){
            state.selectMovie = movie;
        }
    }
})

export default store;