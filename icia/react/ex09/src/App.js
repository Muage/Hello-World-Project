import { createTheme, ThemeProvider } from '@material-ui/core';
import { Route } from 'react-router-dom';
import './App.css';
import CustomerChart from './component/CustomerChart';
// import Banner from './component/Banner';
import CustomerList from './component/CustomerList';
import MenuBar from './component/MenuBar';
import PostList from './component/PostList';

const theme = createTheme({
	typography: {
		fontFamily: 'SCDream3'
	}
})

function App() {
	return (
		<ThemeProvider theme={theme}>
			<div className="App">
				{/* <Banner/> */}

				<Route path='/' component={MenuBar}/>
				<Route path='/customers' component={CustomerList}/>
				<Route path='/chart' component={CustomerChart}/>
				<Route path='/posts' component={PostList}/>
			</div>
		</ThemeProvider>
	);
}

export default App;
