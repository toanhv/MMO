<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model backend\models\Images */

$this->title = Yii::t('backend', 'Create {modelClass}', [
            'modelClass' => 'Images',
        ]);
$this->params['breadcrumbs'][] = ['label' => Yii::t('backend', 'Images'), 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="images-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?=
    $this->render('_form', [
        'model' => $model,
    ])
    ?>

</div>
