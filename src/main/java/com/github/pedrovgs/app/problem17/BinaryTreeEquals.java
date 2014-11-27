/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.app.problem17;

import com.github.pedrovgs.app.binarytree.BinaryNode;

/**
 * Given two binary trees, can you write a method to check if this trees are equals?
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreeEquals {

  /**
   * Recursive implementation for this algorithm. Complexity order in time terms equals to O(N)
   * where N is the number of nodes in the smaller tree. In space terms, the complexity order of
   * this algorithm is O(1) because we are not using any additional data structure to keep nodes
   * information.
   *
   * Related with the execution time of this algorithm is really important take into account the
   * third recursion case where we are going to use "if" short circuit to avoid go through the whole
   * tree and stop comparing nodes once we find one different.
   */
  public boolean areEqualsRecursive(BinaryNode tree1, BinaryNode tree2) {
    if (tree1 == null && tree2 == null) {
      throw new IllegalArgumentException("You can't compare two null trees");
    }
    return areEqualsInner(tree1, tree2);
  }

  private boolean areEqualsInner(BinaryNode tree1, BinaryNode tree2) {
    if (tree1 == null && tree2 != null || tree1 != null && tree2 == null) {
      return false;
    } else if (tree1 == null && tree2 == null) {
      return true;
    } else {
      return tree1.equals(tree2)
          && areEqualsInner(tree1.getLeft(), tree2.getLeft())
          && areEqualsInner(tree1.getRight(), tree2.getRight());
    }
  }
}