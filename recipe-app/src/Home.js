// import './App.css';
// const {  Layout, Menu, Breadcrumb  } = require('antd');
// const { Header, Content, Footer } = Layout;
import { Routs, Route, useParams, Link } from "react-router-dom";
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import 'antd/dist/antd.css';
import './index.css';
import './App.css';
import axios from 'axios';
import { Layout, Menu, Breadcrumb, Card } from 'antd';
const { Header, Content, Footer } = Layout;
const { Meta } = Card;

class Home extends Component {

  constructor(props) {
    super(props);
    this.state = {
      recipes: []
    };
  }
  async getRecommend(){
    const n = 3;
    try{
      const response = await axios.get(`http://localhost:8080/search/recommend/${n}`);
      const responseData = response.data;
      return responseData;
    }catch(e) {
      console.error(e);
    }
  }

  async componentDidMount(){
    const recipes = await this.getRecommend();
    await this.setState({
      recipes
    })
  }

  async componentDidUpdate(){

  }

  render(){
    return (
      <div className="site-layout-background" style={{ padding: 24, minHeight: 580, margin:'auto',textAlign:'center' }}>
        {
          this.state.recipes.map(recipe => {
            return (
              <nav key={recipe.name} style={{display: 'inline-block', margin:'auto'}}>
                <Link to='/details' state={{ name: recipe.name }} >
                  <Card
                    hoverable
                    style={{ width: 340, Height: 580, margin: 20 }}
                    cover={<img alt={recipe.name} src={recipe.img_url} />}
                  >
                    <Meta title={recipe.name} />
                  </Card>
                </Link>
              </nav>
            )
          })
        }
      </div>
    );
  }
}

export default Home;
