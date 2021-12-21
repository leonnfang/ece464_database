import axios from 'axios';
import React, { useState, useEffect, Component } from 'react';
import './index.css';
import { AudioOutlined } from '@ant-design/icons';
import { Routs, Route, useParams, Link } from "react-router-dom";
const {  Layout, Menu, Breadcrumb, Input, Space, Card  } = require('antd');
const { Header, Content, Footer } = Layout;
const { Search } = Input;
const { Meta } = Card;
require('react-dom');
window.React2 = require('react');
console.log(window.React1 === window.React2);

function Overall(props){
  console.log("overall props: ", props);
  const [ recipes, setRecipes ] = useState([]);
  useEffect(async () => {
    const containesKeyword = async function(name) {
      try{
        const response = await axios.get(`http://localhost:8080/search/recipe_contains/${name}`);
        const responseData = response.data;
        const ingredientResponse = await axios.get(`http://localhost:8080/search/ingredient_name_contains/${name}`);
        const ingredientResponseData = ingredientResponse.data;
        // ingredientResponseData.forEach(e => {
        //   if(!responseData.includes(ele=>ele._id===e._id)){
        //     responseData.push(e);
        //   }
        //   return;
        // });
        const concat = responseData.concat(ingredientResponseData);
        // console.log("concat: ", concat);
        const result = concat.reduce((prev, cur)=>{
          if(prev.filter(ele=>ele._id===cur._id).length===0){
            prev.push(cur);
          }
          return prev;
        },[]);
        console.log("name: ", name);
        console.log(result);
        return result;
      }catch(e) {
        console.error(e);
      }
  
    }
    const recipes = await containesKeyword(props.name);
    setRecipes(recipes);
  },[props]);
  

  return (
    <div className="site-layout-background" style={{ padding: 24, minHeight: 380, textAlign:'center' }}>
      {
        recipes.map(recipe => {
          const url = `/details`;
          return (
            <nav key={recipe.name} style={{display: 'inline-block', margin:'auto'}}>
              <Link to={url} state={{ name: recipe.name }} >
                <Card
                  hoverable
                  style={{ width: 240, maxHeight: 500, margin: 10 }}
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

export default Overall;
