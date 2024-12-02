<template>
    <div>
        <component :is="layout"></component>
        <div class="container mt-3">
            <h1 class="display-1 text-center">영화 목록</h1>

            <router-link to="AddMovie">대여영화 추가</router-link>
            <table class="table table-hover mt-3">
                <thead class="table-dark">
                    <tr>
                        <th>번호</th>
                        <th>장르</th>
                        <th>제목</th>
                        <th>감독</th>
                        <th>배급사</th>
                        <th>개봉일</th>
                        <th>상영시간</th>
                        <th>줄거리</th>
                        <th>bcode</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="cursor-pointer" v-for="row in result" :key="row.movie_num"
                        v-on:click="$event => href(row)">
                        <td>{{ row.movie_num }}</td>
                        <td>{{ row.genre }}</td>
                        <td style="color: blueviolet;">{{ row.title }}★{{ row.title.length }}★</td>
                        <td>{{ row.directore }}</td>
                        <td>{{ row.producer }}</td>
                        <td>{{ row.release_date }}</td>
                        <td>{{ row.runtime }}</td>
                        <td>{{ row.description }}</td>
                        <td>{{ row.bcode }}</td>
                        <td><button @click.stop="borrowMovie(row)" type="submit">대여하기</button></td>
                    </tr>

                </tbody>
            </table>
        </div>
    </div>

</template>

<script>
import axios from 'axios';
import store from '@/store';
import router from '@/router';
import LayOutMain from './LayOutMain.vue';
export default {
    name: 'MovieList',
    data() {
        return {
            result: []
        }
    },
    created() {
        this.getDB()
        console.log(store)
    },
    computed: {
        layout() {
            return this.$route.meta.layout
        }
    },
    methods: {
        getDB() {
            axios
                .post('http://localhost:8080/movieList')
                .then((response) => {
                    console.log(response)
                    this.result = response.data.result
                })
                .catch((error) => {
                    console.log(error)
                })
        },

        href(row) {
            console.log(row)
            store.commit('setMovie', row) // vuex에 저장함
            this.$router.push({ name: 'MovieOne', params: row }) // 라우터 설정을 안해놓으면 넘기는 값이 너무 많아 라우터 경로를 번호만 받도록.
        },
        borrowMovie(movie) {
            this.$store.commit('addToCart', movie); // 장바구니에 영화 추가
            alert(`'${movie.title}'이(가) 장바구니에 추가되었습니다!`);
        },

    },
}
</script>

<style></style>