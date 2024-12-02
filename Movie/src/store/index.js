import { createStore } from 'vuex'
import axios from 'axios';

const store = createStore({
    // vuex 상태정의
    state() {
        return {
            user: {}, // 사용자 정보 상태
            selectMovie: {},
            cart: {} // 장바구니
        }
    },
    // 상태를 변경하는 뮤테이션
    mutations: {
        setUser(state, value) {
            state.user = value;
        },
        setMovie(state, movie) {
            state.selectMovie = movie;
        },
        // 사용자 ID를 상태에 저장
        setUserId(state, userId) {
            state.userId = userId; // userId를 상태에 저장
        },
        addToCart(state, movie) {
            const CartCheck = state.cart.some((item) => item.movie_num === movie.movie_num);
            if (!CartCheck) {
                state.cart.push(movie);
            }
        },
        removeFromCart(state, movie_num) {
            state.cart = state.cart.filter((item) => item.movie_num !== movie_num);
        },
    },
    getters:{
        cartItems: (state) => state.cart,
    },
    // 비동기 작업을 처리하는 액션
    actions: {
        // 서버에서 사용자 정보를 가져오는 비동기 함수 
        async fetchUser({ commit, state }) {
            try {
                // 서버에 사용자 정보를 요청하는 axios Post 요청
                const response = await axios.post('http://localhost:8080/user', {});
                console.log('응답 데이터:', response.data);  // 응답 데이터를 확인

                // userId를 기준으로 사용자 찾기
                // 응답데이터가 result로 이루어진 배열이라서 result 배열을 찾아서 userId에 맞는 사용자 객체를 찾음
                // .find(): 배열 내에서 조건이 맞는 첫번째 요소 반환
                // u => u.userId === state.userId : 배열의 각 요소 u에서 userId가 현재상태 state.userId와 일치하는지 확인
                // u는 배열의 각 사용자 객체를 의미함.

                //ex) 코드흐름 예시
                // response.data.result
                // response.data.result = [
                //     { userId: 'user1', userName: 'Alice', userEmail: 'alice@example.com' },
                //     { userId: 'user2', userName: 'Bob', userEmail: 'bob@example.com' }
                // ];

                // state.userId = 'user1';

                // {
                //     userId: 'user1',
                //     userName: 'Alice',
                //     userEmail: 'alice@example.com'
                // }

                const user = response.data.result.find(u => u.userId === state.userId);

                // 사용자가 존재하면 상태에 사용자 정보를 저장함.
                if (user) {
                    commit('setUser', user); // 찾아낸 사용자 정보를 상태에 저장
                } else {
                    console.error("사용자를 찾을 수 없습니다.");
                }
            } catch (error) {
                console.error("사용자 정보를 가져오는 중 오류 발생:", error);
            }
        },
    },
})

export default store;